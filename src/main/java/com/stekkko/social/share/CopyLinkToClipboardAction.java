package com.stekkko.social.share;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.ui.MessageType;
import org.jetbrains.annotations.NotNull;
import java.awt.datatransfer.StringSelection;



public class CopyLinkToClipboardAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent actionEvent) {

        String selection = ActionService.extractSelectedText(actionEvent);
        String fileName = ActionService.extractFileName(actionEvent);
        String fileExtension = ActionService.extractFileExtension(actionEvent);


        if (selection == null || selection.trim().length() == 0) {
            ActionService.showBalloonPopup(actionEvent, "There is nothing to share.", MessageType.WARNING);
            return;
        }

        try {
            String linkToPastebin = PastebinService.share(selection, fileExtension, fileName);
            CopyPasteManager.getInstance().setContents(new StringSelection(linkToPastebin));

            ActionService.showBalloonPopup(
                    actionEvent
                    , "Share with Pastebin successful. <br/>Link is waiting in your clipboard.<br/>"
                    , MessageType.INFO);
        } catch (Exception e) {

            ActionService.showBalloonPopup(
                    actionEvent
                    , "Something went wrong.<br/><br/>Problem description: " +
                    e.getMessage() + "<br/><br/>Please try again and if problem persists, contact with author."
                    , MessageType.ERROR);
            e.printStackTrace();
        }
    }



}
