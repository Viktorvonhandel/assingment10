package com.example.assingment10;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ListUserInRecycleViewAdapter extends RecyclerView.Adapter<ListUserInRecycleViewAdapter.UserViewHolder> {
    private List<User> userList;

    public ListUserInRecycleViewAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textFirstName.setText(user.getFirstName());
        holder.textLastName.setText(user.getLastName());
        holder.textEmail.setText(user.getEmail());
        holder.textDegreeProgram.setText(user.getDegreeProgram());
        holder.textUserDegrees.setText(user.getUserDegrees());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textFirstName;
        TextView textLastName;
        TextView textEmail;
        TextView textDegreeProgram;
        TextView textUserDegrees; // Lisätty educationalLevel TextView

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstName = itemView.findViewById(R.id.textFirstName);
            textLastName = itemView.findViewById(R.id.textLastName);
            textEmail = itemView.findViewById(R.id.textEmail);
            textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
            textUserDegrees = itemView.findViewById(R.id.textUserDegrees);
        }
    }
}
