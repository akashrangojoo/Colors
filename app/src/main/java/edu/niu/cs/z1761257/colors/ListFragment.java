package edu.niu.cs.z1761257.colors;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private OnItemSelectedListener listener;
    private String information;



    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_list, container, false);

        Button plumBtn = (Button)view.findViewById(R.id.plumButton),
               goldBtn = (Button)view.findViewById(R.id.goldButton),
               blueBtn = (Button)view.findViewById(R.id.blueButton);

        plumBtn.setOnClickListener(shadeChange);
        goldBtn.setOnClickListener(shadeChange);
        blueBtn.setOnClickListener(shadeChange);
        return view;

    }//end of onCreateView

    private View.OnClickListener shadeChange = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            information = (String) v.getContentDescription();
            listener.onShadeItemSelected(information);
        }
    };

    public interface OnItemSelectedListener{
        public void onShadeItemSelected( String colorInfo );
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener) activity ;
        }
        else{
            throw new ClassCastException(activity.toString() + " must implement ListFragment.OnItemSelectedListener");
        }
    }//end of OnAttach

}
