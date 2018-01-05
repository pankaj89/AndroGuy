# SimpleRecyclerViewAdapter

##### This is library which uses databinding and set the adapater without creating new adapter files


### How to use

```
private ArrayList<Matches> matches = new ArrayList<>();
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(SimpleAdapter.with(R.layout.items, list, new SimpleAdapter.Binder<String, ItemsBinding>() {
    @Override
    public void onBind(int position, String model, ItemsBinding binding) {
        binding.txtFirstName.setText(model);
    }
}));
```

Note: Don't change new instance of matches array list

