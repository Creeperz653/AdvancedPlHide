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

package tk.bluetree242.advancedplhide;

import java.util.ArrayList;
import java.util.List;

public class CompleterModifier {

    public static void removePluginPrefix(CommandCompleterList list) {
        for (CommandCompleter completer : new ArrayList<>(list)) {
            if (completer.getName().contains(":")) completer.remove();
        }
    }


    public static void handleCompleter(CommandCompleterList list, Group playerGroup, boolean blacklist) {
        if (Platform.get().getConfig().remove_plugin_prefix())
            removePluginPrefix(list);

        if (playerGroup != null)
            if (!blacklist) applyBlacklist(list, playerGroup.getTabComplete(true));
            else applyWhitelist(list, playerGroup.getTabComplete(true));
    }

    public static void applyBlacklist(CommandCompleterList list, List<CommandCompleter> toBlacklist) {
        List<String> commands = new ArrayList<>();
        for (CommandCompleter completer : toBlacklist) {
            commands.add(completer.getName());
        }
        for (CommandCompleter completer : new ArrayList<>(list)) {
            if (commands.contains(completer.getName())) completer.remove();
        }
    }

    public static void applyWhitelist(CommandCompleterList list, List<CommandCompleter> toWhitelist) {
        List<String> commands = new ArrayList<>();
        for (CommandCompleter completer : toWhitelist) {
            commands.add(completer.getName());
        }
        for (CommandCompleter completer : new ArrayList<>(list)) {
            if (!commands.contains(completer.getName())) completer.remove();
        }
    }
}
