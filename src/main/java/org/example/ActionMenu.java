package org.example;


import lombok.Getter;


public class ActionMenu {
    @Getter
    public enum actionMenu {
        ACTION_ADD_WAREHOUSE(1, "Добавить склад"),
        ACTION_DELETE_WAREHOUSE(2, "Удалить склад"),
        ACTION_EDIT_WAREHOUSE(3, "Изменить склад"),
        ACTION_SHOW_ALL_WAREHOUSES(4, "Показать все склады"),

        ACTION_ADD_INVENTORY(5, "Добавить инвентарь"),
        ACTION_DELETE_INVENTORY(6, "Удалить инвентарь"),
        ACTION_EDIT_INVENTORY(7, "Изменить инвентарь"),
        ACTION_SHOW_ALL_INVENTORIES(8, "Показать все инвентари"),

        ACTION_ADD_RACKET(9, "Добавить ракетку"),
        ACTION_DELETE_RACKET(10, "Удалить ракетку"),
        ACTION_EDIT_RACKET(11, "Изменить ракетку"),
        ACTION_SHOW_ALL_RACKETS(12, "Показать все ракетки"),

        ACTION_ADD_SHUTTLECOCK(13, "Добавить воланы"),
        ACTION_DELETE_SHUTTLECOCK(14, "Удалить воланы"),
        ACTION_EDIT_SHUTTLECOCK(15, "Изменить воланы"),
        ACTION_SHOW_ALL_SHUTTLCOCKS(16, "Показать все воланы"),
        ACTION_SHOW_ALL_ITEM(17, "Вывести все предметы"),

        ACTION_EXIT(18, "Выход");


        private final int id;
        private final String string;

        actionMenu(int id, String string) {
            this.id = id;
            this.string = string;
        }

        public static actionMenu getByIdEnum(int id) {
            for (actionMenu action : actionMenu.values()) {
                if (action.getId() == id) {
                    return action;
                }
            }
            return null;
        }

        public static void checkActionById(int inputId) {
            actionMenu action = actionMenu.getByIdEnum(inputId);
            if (action == null) {
                System.out.println("Ошибка: неверный ID команды. Попробуйте снова.");
            } else {
                System.out.println("Вы выбрали: " + action.getString());
            }
        }
    }

}
