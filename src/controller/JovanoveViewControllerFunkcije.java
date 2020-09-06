/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;
import java.util.TreeSet;
import model.Account;
import model.RegisteredUser;
import model.UserType;
import view.createUser.CreateAccountEvent;
import view.createUser.CreateAccountListener;
import view.createUser.CreateAccountPanel;
import view.createUser.GenerateUsernameEvent;
import view.createUser.GenerateUsernameListener;

/**
 *
 * @author jovandjordjic
 */
public class JovanoveViewControllerFunkcije {

    public static RecipeBook rb;

    public CreateAccountPanel createNewAccountPanel() {
        CreateAccountPanel cap = new CreateAccountPanel();

        cap.setGeneratePasswordListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = generatePassword();
                cap.setPasswordTextField(password);
            }
        });

        cap.setGenerateUserNameListener(new GenerateUsernameListener() {
            @Override
            public void generateUsernameEventOccured(GenerateUsernameEvent e) {
                String email = e.getEmail();
                String newUsername;

                String name = e.getName();
                String surname = e.getSurname();
                if (email.equals("")) {
                    newUsername = email;

                } else {
                    if (name.equals("") && surname.equals("")) {
                        return;
                    } else {
                        newUsername = name.toLowerCase() + "." + surname.toLowerCase();
                    }
                }

                int counter = 0;
                while (true) {
                    if (rb.checkAccount(newUsername)) {
                        counter++;
                        newUsername += counter;
                    } else {
                        break;
                    }
                }

                cap.setUsernameTextField(newUsername);
            }
        });

        cap.setCreateAccountListener(new CreateAccountListener() {
            @Override
            public void createNewAccount(CreateAccountEvent e) {

                boolean allDataEntered = true;

                String name = e.getName();
                String surname = e.getSurname();
                String email = e.getEmail();
                String username = e.getUsername();
                String password = e.getPassword();

                LocalDate birthDate = e.getBirthDate();

                if (name.isBlank()) {
                    cap.colorTextField(email);
                    allDataEntered = false;
                }
                if (surname.isBlank()) {
                    cap.colorTextField("surname");
                    allDataEntered = false;
                }
                if (username.isBlank()) {
                    cap.colorTextField("username");
                    allDataEntered = false;
                }
                if (password.isBlank()) {
                    cap.colorTextField("password");
                    allDataEntered = false;
                }

                if (!(cap.checkEmailFields())) {
                    allDataEntered = false;
                }

                if (allDataEntered) {
                    if (rb.checkAccount(username)) {
                        cap.colorTextField("username");
                        return;
                    }

                    Account newAcc = new Account();
                    newAcc.setEmail(email);
                    newAcc.setUsername(username);
                    newAcc.setPassword(password);

                    RegisteredUser newAccOwner = new RegisteredUser();
                    newAccOwner.setUserType(UserType.user);
                    newAccOwner.setBirthDate(birthDate);
                    newAccOwner.setFollowing(new TreeSet<>());
                    newAccOwner.setName(name);
                    newAccOwner.setSurname(surname);
                    newAccOwner.setReviews(new TreeSet<>());
                    newAccOwner.setPrivileged(false);
                    newAccOwner.setAccount(newAcc);

                }

            }
        });

        cap.setVisible(true);
        return cap;
    }

    public static String generatePassword() {
        String password = "";

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%&*+=[].?><";

        Random randomizer = new Random();
        int choice;
        int charLocation;
        for (int i = 0; i < 8; i++) {
            choice = randomizer.ints(1, 1, 5).min().getAsInt();
            switch (choice) {
                case 1:
                    charLocation = randomizer.ints(1, 0, lowercaseChars.length()).min().getAsInt();
                    password += lowercaseChars.charAt(charLocation);
                    break;
                case 2:
                    charLocation = randomizer.ints(1, 0, uppercaseChars.length()).min().getAsInt();
                    password += uppercaseChars.charAt(charLocation);
                    break;
                case 3:
                    charLocation = randomizer.ints(1, 0, digits.length()).min().getAsInt();
                    password += digits.charAt(charLocation);
                    break;
                default:
                    charLocation = randomizer.ints(1, 0, specialChars.length()).min().getAsInt();
                    password += specialChars.charAt(charLocation);
                    break;
            }
        }
        return password;
    }
}
