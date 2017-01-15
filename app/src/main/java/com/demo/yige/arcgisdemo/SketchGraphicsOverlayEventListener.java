package com.demo.yige.arcgisdemo;

/**
 * Created by yige on 2016/12/14.
 */

public interface SketchGraphicsOverlayEventListener {
    /**
     * Called when the state of the undo event stack changes. If true, an undo can be
     * performed and hence the undo button should be enabled. If false, the undo event
     * stack is empty and the undo button should be disabled.
     *
     * @param undoEnabled true if the undo button should be enabled
     */
    void onUndoStateChanged(boolean undoEnabled);

    /**
     * Called when the state of the redo event stack changes. If true, an redo can be
     * performed and hence the redo button should be enabled. If false, the redo event
     * stack is empty and the redo button should be disabled.
     *
     * @param redoEnabled true if the redo button should be enabled
     */
    void onRedoStateChanged(boolean redoEnabled);

    /**
     * Called when the state of clearing the drawings changes. If true, there are currently
     * drawings on the SketchGraphicsOverlay which can be cleared, and hence the clear
     * button should be enabled. If false, the SketchGraphicsOverlay is empty and the
     * clear button should be disabled.
     *
     * @param clearEnabled true if the clear button should be enabled
     */
    void onClearStateChanged(boolean clearEnabled);

    /**
     * Called when a drawing is finished. When a drawing is finished, the currently selected
     * drawing button can be reset.
     */
    void onDrawingFinished();
}
