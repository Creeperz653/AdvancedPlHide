/*
 *  LICENSE
 * AdvancedPlHide
 * -------------
 * Copyright (C) 2021 - 2021 BlueTree242
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 *  END
 */

package tk.bluetree242.advancedplhide.spigot.impl.cmd;

import tk.bluetree242.advancedplhide.CommandCompleter;
import tk.bluetree242.advancedplhide.CommandCompleterList;

import java.util.ArrayList;
import java.util.List;

public class StringCommandCompleterList extends CommandCompleterList {

    public StringCommandCompleterList(String[] list) {
        for (String s : list) {
            add(new StringCommandCompleter(s, this));
        }
    }


    @Override
    public String[] export() {
        List<String> cmds = new ArrayList<>();
        for (CommandCompleter completer : this) {
            cmds.add("/" + completer.getName());
        }
        return cmds.toArray(new String[0]);
    }
}
