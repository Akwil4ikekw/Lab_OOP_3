
import static org.example.ActionMenu.actionMenu;

import java.util.List;
import java.util.Scanner;

import Database.BadmintonRacket.BadmintonRacketDao;
import Database.Shuttlecock.ShuttlecockDao;
import Database.SportInventory.SportInventoryDao;
import Database.Warehouse.WarehouseDao;
import org.example.Table.*;


public class Main {
    public static void main(String[] args){
        actionMenu action = null;

        Scanner scanner = new Scanner(System.in);
        int inputId = 0;
        do {
            printActions();
            try {
                inputId = Integer.parseInt((scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                continue;
            }

            action = actionMenu.getByIdEnum(inputId);

            switch (action) {
                case ACTION_ADD_WAREHOUSE -> {
                    WarehouseDao warehouseDao = new WarehouseDao();
                    System.out.println("Введите название склада");
                    String name = scanner.nextLine();
                    System.out.println("Введите локацию");
                    String location = scanner.nextLine();

                    Warehouse warehouse = new Warehouse();
                    warehouse.setName(name);
                    warehouse.setLocation(location);
                    warehouseDao.save(warehouse);

                }
                case ACTION_EDIT_WAREHOUSE -> {
                    WarehouseDao warehouseDao = new WarehouseDao();
                    System.out.println("Введите ID склада");
                    int warehouseId = Integer.parseInt((scanner.nextLine()));
                    warehouseDao.getById(warehouseId);
                    System.out.println("Введите название склада");
                    String name = scanner.nextLine();
                    System.out.println("Введите локацию");
                    String location = scanner.nextLine();

                    Warehouse warehouse = new Warehouse();
                    warehouse.setName(name);
                    warehouse.setLocation(location);
                    warehouseDao.save(warehouse);
                }
                case ACTION_DELETE_WAREHOUSE -> {
                    WarehouseDao warehouseDao = new WarehouseDao();
                    System.out.println("Введите ID склада");
                    int warehouseId = Integer.parseInt((scanner.nextLine()));
                    warehouseDao.delete(warehouseId);
                }
                case ACTION_SHOW_ALL_WAREHOUSES -> {
                    WarehouseDao warehouseDao = new WarehouseDao();
                    List<Warehouse> listEntity = warehouseDao.getAll();
                    for (Warehouse item : listEntity) {
                        System.out.println(item.toString());
                    }
                }
                case ACTION_ADD_INVENTORY -> {
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    WarehouseDao warehouseDao = new WarehouseDao();
                    System.out.println("Введите название склада");
                    String name = scanner.nextLine();
                    System.out.println("Введите id склада");
                    int warehouseId = Integer.parseInt((scanner.nextLine()));
                    SportInventory sportInventory = new SportInventory();
                    sportInventory.setLabel(name);


                    Warehouse warehouse = warehouseDao.getById(warehouseId);
                    sportInventory.setWarehouseId(warehouse);
                    sportInventoryDao.save(sportInventory, warehouse.getClass(),warehouseId);

                }
                case ACTION_EDIT_INVENTORY -> {
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    System.out.println("Введите название инвентаря");
                    int inventoryId = Integer.parseInt((scanner.nextLine()));
                    WarehouseDao warehouseDao = new WarehouseDao();
                    System.out.println("Введите название инвентаря");
                    String name = scanner.nextLine();

                    String manufacture = scanner.nextLine();
                    System.out.println("Введите id склада");
                    int warehouseId = Integer.parseInt((scanner.nextLine()));

                    SportInventory sportInventory = sportInventoryDao.getById(inventoryId);
                    sportInventory.setLabel(name);

                    Warehouse warehouse = warehouseDao.getById(warehouseId);
                    sportInventory.setWarehouseId(warehouse);
                    sportInventoryDao.update(sportInventory);
                }
                case ACTION_DELETE_INVENTORY -> {
                    System.out.println("Введите ID инвернтаря ");
                    int inventoryId = Integer.parseInt((scanner.nextLine()));
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    sportInventoryDao.delete(inventoryId);
                }
                case ACTION_SHOW_ALL_INVENTORIES -> {
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    List<SportInventory> listEntity = sportInventoryDao.getAll();
                    for (SportInventory item : listEntity) {
                        System.out.println(item.toString());
                    }
                }
                case ACTION_ADD_RACKET -> {
                    BadmintonRacketDao badmintonRacketDao = new BadmintonRacketDao();
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    System.out.println("Введите производителя ракетки");
                    String manufacture = scanner.nextLine();
                    System.out.println("Введите название ракетки");
                    String name = scanner.nextLine();
                    System.out.println("Введите id инвентаря ");
                    int inventoryId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите натяжение ракетки");
                    int string_tension = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите жесткость ракетки");
                    String rigidity_racket = scanner.nextLine();



                    BadmintonRacket badmintonRacket = new BadmintonRacket();
                    badmintonRacket.setManufacture(manufacture);
                    badmintonRacket.setName(name);
                    badmintonRacket.setString_tension(string_tension);
                    badmintonRacket.setRigidity_racket(rigidity_racket);


                    SportInventory sportInventory = sportInventoryDao.getById(inventoryId);
                    badmintonRacket.setSportInventory(sportInventory);
                    badmintonRacketDao.save(badmintonRacket, sportInventory.getClass(),inventoryId);

                    badmintonRacketDao.save(badmintonRacket);
                }
                case ACTION_DELETE_RACKET -> {
                    BadmintonRacketDao badmintonRacketDao = new BadmintonRacketDao();
                    System.out.println("Введите ID ракетки");
                    BadmintonRacket badmintonRacket= badmintonRacketDao.getById(Integer.parseInt(scanner.nextLine()));
                    badmintonRacketDao.delete(badmintonRacket.getId());
                }

                case ACTION_EDIT_RACKET -> {
                    BadmintonRacketDao badmintonRacketDao = new BadmintonRacketDao();
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    System.out.println("Введите Id ракетки");
                    BadmintonRacket badmintonRacket = badmintonRacketDao.getById(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Введите производителя ракетки");
                    String manufacture = scanner.nextLine();
                    System.out.println("Введите название ракетки");
                    String name = scanner.nextLine();
                    System.out.println("Введите id инвентаря ");
                    String inventoryId = scanner.nextLine();
                    System.out.println("Введите натяжение ракетки");
                    int string_tension = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите жесткость ракетки");
                    String rigidity_racket = scanner.nextLine();

                    SportInventory sportInventory = sportInventoryDao.getById(Integer.parseInt(inventoryId));

                    badmintonRacket.setManufacture(manufacture);
                    badmintonRacket.setName(name);
                    badmintonRacket.setSportInventory(sportInventory);
                    badmintonRacket.setString_tension(string_tension);
                    badmintonRacket.setRigidity_racket(rigidity_racket);
                    badmintonRacketDao.update(badmintonRacket);
                }
                case ACTION_SHOW_ALL_RACKETS -> {
                    BadmintonRacketDao badmintonRacketDao = new BadmintonRacketDao();
                    List<BadmintonRacket> listEntity = badmintonRacketDao.getAll();
                    for (BadmintonRacket item : listEntity) {
                        System.out.println(item.toString());
                    }
                }
                case ACTION_ADD_SHUTTLECOCK -> {
                    ShuttlecockDao shuttlecockDao = new ShuttlecockDao();
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    System.out.println("Введите производителя воланов");
                    String manufacture = scanner.nextLine();
                    System.out.println("Введите название воланов");
                    String name = scanner.nextLine();
                    System.out.println("Введите id инвентаря ");
                    int inventoryId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите сопростивнеие полета воланов");
                    String resistanceToFly = (scanner.nextLine());
                    System.out.println("Введите тип воланов");
                    String typeShuttle = scanner.nextLine();
                    Shuttlecock shuttlecock = new Shuttlecock();
                    shuttlecock.setManufacture(manufacture);
                    shuttlecock.setName(name);
                    shuttlecock.setResistanceToFly(resistanceToFly);
                    shuttlecock.setTypeShuttlecock(typeShuttle);

                    SportInventory sportInventory = sportInventoryDao.getById(inventoryId);
                    shuttlecock.setSportInventory(sportInventory);
                    shuttlecockDao.save(shuttlecock, sportInventory.getClass(),inventoryId);

                }
                case ACTION_DELETE_SHUTTLECOCK -> {
                    ShuttlecockDao shuttlecockDao = new ShuttlecockDao();
                    System.out.println("Введите ID воланов");
                    Shuttlecock shuttlecock = shuttlecockDao.getById(Integer.parseInt((scanner.nextLine())));
                    shuttlecockDao.delete(shuttlecock.getId());
                }
                case ACTION_EDIT_SHUTTLECOCK -> {
                    ShuttlecockDao shuttlecockDao = new ShuttlecockDao();
                    SportInventoryDao sportInventoryDao = new SportInventoryDao();
                    System.out.println("Введите Id волана");
                    Shuttlecock shuttlecock = shuttlecockDao.getById(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Введите производителя волана");
                    String manufacture = scanner.nextLine();
                    System.out.println("Введите название воланов");
                    String name = scanner.nextLine();
                    System.out.println("Введите id инвентаря ");
                    String inventoryId = scanner.nextLine();
                    System.out.println("Введите сопростивнеие полета воланов");
                    String resistanceToFly = (scanner.nextLine());
                    System.out.println("Введите тип воланов");
                    String typeShuttle = scanner.nextLine();
                    shuttlecock.setManufacture(manufacture);
                    shuttlecock.setName(name);
                    shuttlecock.setResistanceToFly(resistanceToFly);
                    shuttlecock.setTypeShuttlecock(typeShuttle);
                    shuttlecock.setSportInventory(sportInventoryDao.getById(Integer.parseInt(inventoryId)));
                    shuttlecockDao.update(shuttlecock);
                }
                case ACTION_SHOW_ALL_SHUTTLCOCKS -> {
                    ShuttlecockDao shuttlecockDao = new ShuttlecockDao();
                    List<Shuttlecock> listEntity = shuttlecockDao.getAll();
                    for (Shuttlecock item : listEntity) {
                        System.out.println(item.toString());
                    }
                }
            }



        } while  (action != actionMenu.ACTION_EXIT);
    }
    public static void printActions() {
        System.out.println("Доступные команды:");
        for (actionMenu action : actionMenu.values()) {
            System.out.printf("%2d - %s%n", action.getId(), action.getString());
        }
    }
}
