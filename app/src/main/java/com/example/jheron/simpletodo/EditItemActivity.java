package com.example.jheron.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {

    EditText etText;
    String item;
    int pos;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_item);
        etText = (EditText) findViewById(R.id.editText);
        item = getIntent().getStringExtra("item_text");
        pos = getIntent().getIntExtra("pos", 0);
        etText.setText(item);
        etText.setSelection(item.length());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

//    public void setupListViewListener() {
//        etText.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                   public boolean onItemClick(AdapterView<?> adapter,
//                                                   View item, int pos, long id) {
//                        items.remove(pos);
//                        itemsAdapter.notifyDataSetChanged();
//                        writeItems();
//                       return true;
//                    }
//
//                    ;
//                });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.editText);
        Intent data = new Intent();
        data.putExtra("item_text", etName.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
