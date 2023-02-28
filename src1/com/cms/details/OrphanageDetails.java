bbpackage com.cms.details;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cms.daoimpl.OrphanageDaoImpl;
import com.cms.pojo.Orphanage;

public class OrphanageDetails {
	public static OrphanageDaoImpl odaoimpl = new OrphanageDaoImpl();
	static Orphanage o = new Orphanage();
	static Scanner scan = new Scanner(System.in);

	public static void OrphanageInfo() throws SQLException, IOException {

		while (true) {
			System.out.println("***************************************************");
			System.out.println("Enter......1->Add Orphanages");
			System.out.println("Enter......2->View All Orphanages");
			System.out.println("Enter......3->View Orphanage");
			System.out.println("Enter......4->Update Orphanage");
			System.out.println("Enter......5->Check Food Availability");
			System.out.println("Enter......6->Back");
			System.out.println("***************************************************");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				int added = odaoimpl.addOrphanages(o);
				if (added != 0) {
					System.out.println("Orphanage added to database....");
				} else {
					System.out.println("Orphanages not added to database....");
				}
				break;
			case 2:
				List<Orphanage> viewall = odaoimpl.viewAllOrphanages();
				if (viewall != null) {
					for (Orphanage o : viewall) {
						System.out.format("%-10s%-20s%-20s%-25s%-30s%-15s\n ", o.getoId(), o.getoName(),
								o.getoAddress(), o.getoMobileNo(), o.getOemail(), o.getFoodNeed());
					}
				} else {
					System.err.println("List is empty");
				}
				break;
			case 3:
				System.out.println("Enter Orphanage name ");
				String name = scan.next();
				Orphanage o1 = odaoimpl.viewOrphanage(name);
				if (o1 != null) {
					System.out.format("%-10s%-20s%-20s%-25s%-30s%-15s\n ", o1.getoId(), o1.getoName(), o1.getoAddress(),
							o1.getoMobileNo(), o1.getOemail(), o1.getFoodNeed());
				} else {
					System.out.println("No Orphanage is there by " + name + " this name");
				}
				break;
			case 4:
				System.out.println("Enter Restaurant name ");
				String name1 = scan.next();
				int update = odaoimpl.updateOrphanage(name1);
				if (update != 0) {
					System.out.println("Orphanage Data updated");
				} else {
					System.out.println("Orphanage Data not updated");
				}
				break;
			case 5:
				System.out.println("Enter Restaurant Address");
				String address = scan.next();
				odaoimpl.checkFoodAvailability(address);

				break;
			case 6:
				AdminDetails.adminInfo();
				break;
			default:
				System.out.println("Choose valid option");
			}
		}
	}
}
