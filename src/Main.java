

import controllers.MController;
import data.Database;
import data.interfaces.DBInterface;
import repositories.MRepository;
import repositories.interfaces.IMRepository;

    public class Main {

        public static void main(String[] args) {//Creating new objects and launching application
            DBInterface database= new Database();
            IMRepository myRepository = new MRepository(database);
            MController myController = new MController(myRepository);
            MyApplication myApplication = new MyApplication(myController );
            myApplication.start();
        }
    }


