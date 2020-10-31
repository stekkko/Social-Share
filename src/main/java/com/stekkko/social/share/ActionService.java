package com.stekkko.social.share;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;

import java.util.Objects;

public class ActionService {

    public static void showBalloonPopup(AnActionEvent actionEvent, String htmlText, MessageType messageType) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(DataKeys.PROJECT.getData(actionEvent.getDataContext()));

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(htmlText, messageType, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.getComponent()), Balloon.Position.atRight);
    }

    public static String extractSelectedText(AnActionEvent actionEvent) {
        Editor editor = DataKeys.EDITOR.getData(actionEvent.getDataContext());

        return Objects.requireNonNull(editor).getSelectionModel().getSelectedText();
    }

    public static String extractFileExtension(AnActionEvent actionEvent) {
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(actionEvent.getDataContext());

        return file == null ? "" : file.getExtension();
    }

    public static String extractFileName(AnActionEvent actionEvent) {
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(actionEvent.getDataContext());

        return file == null ? "" : file.getName();
    }
}
