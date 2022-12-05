package ricardo.ale.fragmentdemo1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {

    private View root;
    private TextView textView;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root==null){
            root =  inflater.inflate(R.layout.fragment_blank1, container, false);
        }

        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.btn);

        button.setOnClickListener(view -> textView.setText("Yeah, I' fine ! "));
        return root;
    }
}