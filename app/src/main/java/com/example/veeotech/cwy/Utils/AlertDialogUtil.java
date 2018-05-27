package com.example.veeotech.cwy.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.InputType;
import android.widget.EditText;
/**
 * Created by CWY on 2018/5/15.
 */

public class AlertDialogUtil {
    public Context context;
    EditText editText;
    private DialogPositiveButtonListener listener;

    public AlertDialogUtil(Context context) {
        this.context = context;
    }

    public void showDialog(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage(message);
        dialog.setCancelable(false);//点击框外取消
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (listener != null) {
                    listener.setDialogPositiveButtonListener();
                }
            }

        });
        dialog.setNegativeButton("取消", null);
        dialog.show();
    }

    public void showEditTextDialog(String message){
        editText = new EditText(context);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage(message);
        dialog.setCancelable(false);//点击框外取消
        dialog.setView(editText);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (listener != null) {
                    listener.setDialogPositiveButtonListener();
                }
            }

        });
        dialog.setNegativeButton("取消", null);
        dialog.show();
    }

    public void setDialogPositiveButtonListener(DialogPositiveButtonListener listener) {
        this.listener = listener;
    }

    public interface DialogPositiveButtonListener {
        void setDialogPositiveButtonListener();
    }

    public String getEditText(){
       return editText.getText().toString();
    }
}

