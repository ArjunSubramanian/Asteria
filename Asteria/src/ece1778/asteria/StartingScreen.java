package ece1778.asteria;

import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class StartingScreen extends Fragment {
	FrameLayout preview;
	SurfaceHolder holder;
	private Camera cameraObject;
	private ShowCamera showCamera;
	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private View view;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = inflater.inflate(R.layout.starting_screen, container, false);

		cameraObject = isCameraAvailiable();
		mPlanetTitles = getResources().getStringArray(R.array.drawer_items);
		mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) view.findViewById(R.id.left_drawer);

		// Set the adapter for the list view

		mDrawerList.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.drawer_list_item, mPlanetTitles));
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view,
					int position, long id) {

				cameraObject.stopPreview();

				mDrawerList.setItemChecked(position, true);
				getActivity().setTitle(mPlanetTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
			}
		});
		mTitle = mDrawerTitle = getActivity().getTitle();
		mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActivity().getActionBar().setTitle(mTitle);
				getActivity().getActionBar().hide();
				getActivity().invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActivity().getActionBar().show();
				getActivity().getActionBar().setTitle(mDrawerTitle);

				getActivity().invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}
		};

		showCamera = new ShowCamera(getActivity(), cameraObject);
		holder = showCamera.holdMe;
		preview = (FrameLayout) view.findViewById(R.id.view_area);
		preview.addView(showCamera);
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		getActivity().getActionBar().hide();
		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
		if (cameraObject != null)
			cameraObject.release();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public static Camera isCameraAvailiable() {
		Camera object = null;
		try {

			object = Camera.open();

		} catch (Exception e) {

		}
		return object;
	}

}
