# SimpleRecyclerViewAdapter

##### This is library which uses databinding and set the adapater without creating new adapter files


### How to use

```
private ArrayList<Matches> matches = new ArrayList<>();
public SimpleAdapter matchesAdapter = new SimpleAdapter<Matches>(matches) {
    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(parent, R.layout.item_matches) {
            ItemMatchesBinding binding;

            @Override
            public void create(View view) {
                binding = ItemMatchesBinding.bind(view);
                binding.setParent(MainActivity.this);
            }

            @Override
            public void bind(Matches matches) {
                binding.setPosition(getAdapterPosition());
                binding.setModel(matches);
            }
        };
    }
};
```

#### Set Adapter
```
USING Code : binding.recyclerView.setAdapter(matchesAdapter);
    OR
USING XML : 
<android.support.v7.widget.RecyclerView
    android:id="@+id/recyclerView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:simpleAdapter="@{model.matchesAdapter}"/>
```

Now add/modify matches ArrayList like this and notify
```
matches.addAll(response.matches);
matchesAdapter.notifyDataSetChanged();
```
