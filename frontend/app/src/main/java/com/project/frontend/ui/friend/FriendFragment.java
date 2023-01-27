package com.project.frontend.ui.friend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.project.frontend.R;
import com.project.frontend.databinding.FragmentFriendBinding;
import com.project.frontend.ui.adapter.ListViewAdapter;

public class FriendFragment extends Fragment {

    private FragmentFriendBinding binding;
    private ListView listView;
    private ListViewAdapter listViewAdapter = new ListViewAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFriendBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //List View 연결
        listView = root.findViewById(R.id.friend_list_view);
        listView.setAdapter(listViewAdapter);

        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                a
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