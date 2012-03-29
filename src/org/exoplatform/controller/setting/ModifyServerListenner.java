package org.exoplatform.controller.setting;

import org.exoplatform.singleton.AccountSetting;
import org.exoplatform.singleton.ServerSettingHelper;
import org.exoplatform.ui.SettingServerEditionDialog;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.cyrilmottier.android.greendroid.R;

public class ModifyServerListenner implements OnItemClickListener {
  private Context  mContext;

  private ListView listViewServer;

  public ModifyServerListenner(Context context, ListView listView) {
    mContext = context;
    listViewServer = listView;
  }

  // @Override
  public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
    int domainIndex = Integer.valueOf(AccountSetting.getInstance().getDomainIndex());
    if (domainIndex == pos) {
      String strCannotEdit = mContext.getResources().getString(R.string.CannotEditServer);
      Toast.makeText(mContext, strCannotEdit, Toast.LENGTH_SHORT).show();
    } else {
      ServerSettingHelper.getInstance().setIsNewServer(false);
      ServerSettingHelper.getInstance().setSelectedServerIndex(pos);
      new SettingServerEditionDialog(mContext, listViewServer).show();
    }

  }

}