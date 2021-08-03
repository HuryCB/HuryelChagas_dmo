package br.edu.ednilsonrossi.buscaendereco.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.edu.ednilsonrossi.buscaendereco.R;

public class ItemRepositoryAdapter extends RecyclerView.Adapter<ItemRepositoryAdapter.ViewHolder> {

    private List<Repository> dataSource;

    public ItemRepositoryAdapter(List<Repository> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_lista, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mRepositorysTextView.setText(dataSource.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataSource == null ? 0 : dataSource.size();
    }

    public void setDataSource(List<Repository> dataSource) {
        this.dataSource = dataSource;
        this.notifyDataSetChanged();
    }

    public List<Repository> getDataSource() {
        return dataSource;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mRepositorysTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRepositorysTextView = itemView.findViewById(R.id.textNameRepo);
        }
    }
}
