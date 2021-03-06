/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.dmn.client.editors.expressions.util;

import com.ait.lienzo.client.core.shape.Group;
import com.ait.lienzo.client.core.shape.Text;
import com.ait.lienzo.client.core.shape.TextLineBreakWrap;
import com.ait.lienzo.shared.core.types.TextAlign;
import org.kie.workbench.common.dmn.client.widgets.grid.BaseExpressionGridTheme;
import org.uberfire.ext.wires.core.grids.client.model.GridCell;
import org.uberfire.ext.wires.core.grids.client.widget.context.GridBodyCellRenderContext;
import org.uberfire.ext.wires.core.grids.client.widget.grid.renderers.grids.GridRenderer;
import org.uberfire.ext.wires.core.grids.client.widget.grid.renderers.themes.GridRendererTheme;

public class RendererUtils {

    public static Group getExpressionCellText(final GridBodyCellRenderContext context, final GridCell<String> gridCell) {
        final GridRenderer gridRenderer = context.getRenderer();
        final GridRendererTheme theme = gridRenderer.getTheme();

        final Group g = new Group();
        final Text t = theme.getBodyText()
                .setText(gridCell.getValue().getValue())
                .setListening(false)
                .setX(5)
                .setY(5)
                .setFontFamily(BaseExpressionGridTheme.FONT_FAMILY_EXPRESSION)
                .setTextAlign(TextAlign.LEFT);
        t.setWrapper(new TextLineBreakWrap(t));
        g.add(t);

        return g;
    }

    public static Group getCenteredCellText(final GridBodyCellRenderContext context, final GridCell<String> gridCell) {
        final GridRenderer gridRenderer = context.getRenderer();
        final GridRendererTheme theme = gridRenderer.getTheme();

        final Group g = new Group();
        final Text t = theme.getBodyText()
                .setText(gridCell.getValue().getValue())
                .setListening(false)
                .setX(context.getCellWidth() / 2)
                .setY(context.getCellHeight() / 2);
        g.add(t);
        return g;
    }
}
