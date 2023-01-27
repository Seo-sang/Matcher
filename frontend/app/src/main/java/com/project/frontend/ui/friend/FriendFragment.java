package com.project.frontend.ui.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.project.frontend.DTO.MemberDTO;
import com.project.frontend.R;
import com.project.frontend.databinding.FragmentFriendBinding;
import com.project.frontend.ui.MainActivity;
import com.project.frontend.ui.adapter.ListViewAdapter;
import com.project.frontend.ui.chatting.ChattingActivity;
import com.project.frontend.ui.item.ListViewItem;
import org.jetbrains.annotations.NotNull;

public class FriendFragment extends Fragment {

    private FragmentFriendBinding binding;
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFriendBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listViewAdapter = new ListViewAdapter();
        //List View 연결
        listView = root.findViewById(R.id.friend_list_view);
        listView.setAdapter(listViewAdapter);

        //데이터가 수정되면 다시 불러오기
        listViewAdapter.notifyDataSetChanged();

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