package com.project.frontend.ui.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.project.frontend.DTO.FriendDTO;
import com.project.frontend.DTO.MemberDTO;
import com.project.frontend.R;
import com.project.frontend.databinding.FragmentFriendBinding;
import com.project.frontend.identification.Identification;
import com.project.frontend.ui.MainActivity;
import com.project.frontend.ui.adapter.ListViewAdapter;
import com.project.frontend.ui.chatting.ChattingActivity;
import com.project.frontend.ui.item.ListViewItem;
import com.project.frontend.web.RetrofitClient;
import com.project.frontend.web.RetrofitService;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment {

    private FragmentFriendBinding binding;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private RetrofitService retrofitService = RetrofitClient.getRetrofitService();
    private Identification identification = Identification.getInstance();
    private boolean dataCheck;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFriendBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Log.d("TEST", "userId : " + identification.getUserId());
        dataCheck = false;
        //서버로부터 데이터 받기
        ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();
        retrofitService.getFriends(identification.getUserId()).enqueue(new Callback<FriendDTO>() {
            @Override
            public void onResponse(Call<FriendDTO> call, Response<FriendDTO> response) {
                if(response.isSuccessful()) {
                    FriendDTO body = response.body();


                    for (MemberDTO friend : body.getFriends()) {
                        Log.d("TEST1", friend.toString());
                        listViewItems.add(new ListViewItem(friend));
                        listViewAdapter.notifyDataSetChanged();
                    }
                    dataCheck = true;
                }
                else {
                    Log.d("TEST", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<FriendDTO> call, Throwable t) {
                Log.d("TEST", "Friend Response Failed");
            }
        });
        Log.d("TEST2", "" + listViewItems.size());

        listViewAdapter = new ListViewAdapter(listViewItems);


        //List View 연결
        listView = root.findViewById(R.id.friend_list_view);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) listViewAdapter.getItem(i);

                String  userId = item.getUserId();
                String  nickname = item.getNickname();
                String  introduction = item.getIntroduction();

                //Dialog 띄우기
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

                dialogBuilder.setTitle(userId);
                dialogBuilder.setMessage(nickname + "\n" + introduction);
                AlertDialog dialog;

                dialogBuilder.setPositiveButton("톡 보내기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //채팅
                        Intent intent = new Intent(getContext(), ChattingActivity.class);
                        startActivity(intent);
                    }
                });

                dialogBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                 dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}