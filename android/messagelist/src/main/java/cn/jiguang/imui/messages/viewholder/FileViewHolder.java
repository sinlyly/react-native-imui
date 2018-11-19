package cn.jiguang.imui.messages.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cn.jiguang.imui.BuildConfig;
import cn.jiguang.imui.commons.models.IFile;
import cn.jiguang.imui.commons.models.IMessage;

import cn.jiguang.imui.R;
import cn.jiguang.imui.messages.MessageListStyle;

public class FileViewHolder<MESSAGE extends IMessage> extends AvatarViewHolder<MESSAGE>  {

    private  final TextView file_name ;
    private  final TextView file_description ;
    private  final View layout_top;


    public FileViewHolder(RecyclerView.Adapter adapter, View itemView, boolean isSender) {
        super(adapter, itemView, isSender);
        file_name  = (TextView)itemView.findViewById(R.id.file_name);
        file_description =  (TextView)itemView.findViewById(R.id.file_description);
        layout_top = itemView.findViewById(R.id.layout_top);
    }

    @Override
    public void onBind(final MESSAGE message) {
        super.onBind(message);
        IFile file = getExtend(message);
        String ext =  file.getExt() != null && !file.getExt().equals("") ? file.getExt() : "未知";
        String file_description_str = "文件格式: "+ ext  + "  文件大小: " +  file.getSize();
        file_description.setText(file_description_str);
        file_name.setText(file.getName());
        layout_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMsgClickListener != null) {
                    mMsgClickListener.onMessageClick(message);
                }
            }
        });
        layout_top.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mMsgLongClickListener != null) {
                    mMsgLongClickListener.onMessageLongClick(message);
                } else {
                    if (BuildConfig.DEBUG) {
                        Log.w("MsgListAdapter", "Didn't set long click listener! Drop event.");
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void applyStyle(MessageListStyle style) {
        super.applyStyle(style);
    }
}
