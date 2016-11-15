package im.chaitanya.StarWarsShips;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.chaitanya.StarWarsShips.Network.Models.RecyclerShip;

/**
 * Straight forward RecyclerView adapter. Nothing funky happening here apart from {@link #setAnimation}
 * which is responsible for the slide in animation of views.
 */
class ShipsAdapter extends RecyclerView.Adapter<ShipsAdapter.ViewHolder> {
    private final List<RecyclerShip> mAllShips;
    private final Context mContext;
    // Allows to remember the last item shown on screen
    private int mLastPosition = -1;

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view_ship_name) TextView shipNameTextView;
        @BindView(R.id.view_ship_cost) TextView shipCostTextView;
        @BindView(R.id.view_ship_films) TextView shipFilmsTextView;
        @BindView(R.id.item_card) LinearLayout container;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    ShipsAdapter(Context context, List<RecyclerShip> allShips) {
        mAllShips = allShips;
        mContext = context;
    }

    @Override
    public ShipsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.itemcard, parent, false);

        // Return a new holder instance
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShipsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        RecyclerShip ship = mAllShips.get(position);

        // Set item views based on your views and data model
        viewHolder.shipNameTextView.setText(ship.getShipName());
        viewHolder.shipCostTextView.setText(ship.getCostInString());
        viewHolder.shipFilmsTextView.setText(ship.getFilms());
        setAnimation(viewHolder.container, position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > mLastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            mLastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return mAllShips.size();
    }
}
