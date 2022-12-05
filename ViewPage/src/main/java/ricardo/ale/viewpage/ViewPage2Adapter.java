package ricardo.ale.viewpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPage2Adapter extends RecyclerView.Adapter<ViewPage2Adapter.ViewPageViewHolder> {

    private List<String> titles = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();

    public ViewPage2Adapter() {
        titles.add("Hello");
        titles.add("aleyyds");
        titles.add("Ricardo");
        titles.add("AndroidStudio");
        titles.add("I");
        titles.add("like");
        titles.add("my");
        titles.add("best");
        titles.add("hello ");
        titles.add("world");

        colors.add(R.color.white);
        colors.add(R.color.black);
        colors.add(R.color.yellow);
        colors.add(R.color.red);
        colors.add(R.color.purple_200);
        colors.add(R.color.purple_500);
        colors.add(R.color.purple_700);
        colors.add(R.color.teal_200);
        colors.add(R.color.teal_700);
        colors.add(R.color.black);


    }


    @NonNull
    @Override
    public ViewPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPageViewHolder holder, int position) {
        holder.mtv.setText(titles.get(position));
        holder.mtv.setBackgroundResource(colors.get(position));
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewPageViewHolder extends RecyclerView.ViewHolder {

        TextView mtv;
        RelativeLayout layout;

        public ViewPageViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.container);
            mtv = layout.findViewById(R.id.tvTitle);
        }
    }

}
