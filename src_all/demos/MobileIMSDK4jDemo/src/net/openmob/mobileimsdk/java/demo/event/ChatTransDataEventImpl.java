/*
 * Copyright (C) 2015 Jack Jiang The MobileIMSDK Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/MobileIMSDK
 *  
 * openmob.net PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * ChatTransDataEventImpl.java at 2015-11-12 21:51:15, code by Jack Jiang.
 * You can contact author with jack.jiang@openmob.net or jb2011@163.com.
 */
package net.openmob.mobileimsdk.java.demo.event;

import net.openmob.mobileimsdk.java.demo.MainGUI;
import net.openmob.mobileimsdk.java.event.ChatTransDataEvent;
import net.openmob.mobileimsdk.java.utils.Log;

public class ChatTransDataEventImpl implements ChatTransDataEvent
{
	private final static String TAG = ChatTransDataEventImpl.class.getSimpleName();
	
	private MainGUI mainGUI = null; 
	
	@Override
	public void onTransBuffer(String fingerPrintOfProtocal, int dwUserid, String dataContent)
	{
		Log.d(TAG, "【DEBUG_UI】收到来自用户"+dwUserid+"的消息:"+dataContent);
		
		if(mainGUI != null)
		{
			this.mainGUI.showToast(dwUserid+"说："+dataContent);
			this.mainGUI.showIMInfo_black(dwUserid+"说："+dataContent);
		}
	}
	
	public ChatTransDataEventImpl setMainGUI(MainGUI mainGUI)
	{
		this.mainGUI = mainGUI;
		return this;
	}

	@Override
	public void onErrorResponse(int errorCode, String errorMsg)
	{
		Log.d(TAG, "【DEBUG_UI】收到服务端错误消息，errorCode="+errorCode+", errorMsg="+errorMsg);
		this.mainGUI.showIMInfo_red("Server反馈错误码："+errorCode+",errorMsg="+errorMsg);
	}
}
