package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);
		//adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Toast toast = new Toast();
				Toast.makeText(LonelyTwitterActivity.this, "Saved", Toast.LENGTH_LONG).show();
				//toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);

				/*Tweet tweet = new ImportantTweet("");
				NormalTweet tweet1 = new NormalTweet("");
				try {
					tweet.setMessage("hello");
				} catch (TweetTooLongException e) {

				}
				ArrayList<Tweet> tweets = new ArrayList<Tweet>();
				tweets.add(tweet);
				tweets.add(tweet1);
				for (Tweet t : tweets){
					Log.d("Some Tag", "The is Important method on this object return " + t.isImportant());
				}

				ArrayList<Tweetable> tweetables = new ArrayList<Tweetable>();
				tweetables.add(tweet);
				tweetables.add(tweet1);

				ArrayList<mood> moodlist = new ArrayList<mood>();
				//moodlist.add(Happymood);
				//moodlist.add(Sadmood); */

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				//saveInFile(text, new Date(System.currentTimeMillis()));

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
                saveInFile();

				//finish();

			}
		});


		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				//Toast.makeText(LonelyTwitterActivity.this, "Saved", Toast.LENGTH_LONG).show();

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.clear();

				//tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
				saveInFile();



			}
		});
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        loadFromFile();
		//String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweets = gson.fromJson(in,listType);

			/*String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}*/

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();
			fos.close();

			/*fos.write(new String(date.toString() + " |\n " + text)
					.getBytes());
			fos.close();*/

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
			//e.printStackTrace();
		}
	}
}