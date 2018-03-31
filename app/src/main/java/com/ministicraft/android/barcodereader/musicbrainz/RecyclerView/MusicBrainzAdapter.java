package com.ministicraft.android.barcodereader.musicbrainz.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ministicraft.android.barcodereader.R;
import com.ministicraft.android.barcodereader.musicbrainz.Release;

import java.util.List;

public class MusicBrainzAdapter extends RecyclerView.Adapter<MusicBrainzHolder> {
    public List<Release> releases;

    public MusicBrainzAdapter(List<Release> releases) {
        this.releases = releases;
    }

    public MusicBrainzAdapter() {
        this.releases = null;
    }

    @Override
    public MusicBrainzHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_cards,parent,false);
        return new MusicBrainzHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicBrainzHolder holder, int position) {
        Release release = releases.get(position);
        holder.bind(release);
    }

    @Override
    public int getItemCount() {
        if (releases!=null) {
            return releases.size();
        } else return 0;
    }
}
