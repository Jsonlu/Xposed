package top.jsonlu.xposed.hook;

import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * Author:JsonLu
 * DateTime:2020/3/17 20:49
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class HookUtils implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("top.jsonlu.xposed.demo"))
            return;

        XposedHelpers.findAndHookMethod("top.jsonlu.xposed.demo.MainActivity", lpparam.classLoader, "onClick", View.class, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                Class clazz = param.thisObject.getClass();
                XposedBridge.log("class name:" + clazz.getName());


                Field field = clazz.getDeclaredField("et_password");
                field.setAccessible(true);

                EditText password = (EditText) field.get(param.thisObject);

                String string = password.getText().toString();
                XposedBridge.log("密码 = " + string);
                password.setText("改你妹啊!!");

            }
        });


    }

}