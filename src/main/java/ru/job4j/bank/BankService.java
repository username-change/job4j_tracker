package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы, которая позволяет добавлять и удалять пользователей,
 * добавлять и управлять их счетами, а также производить переводы между счетами.
 * @author [Alexander]
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему, если он еще не существует.
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по его паспорту.
     * @param passport паспорт пользователя, которого необходимо удалить
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Метод добавляет новый счет к пользователю, если счет еще не существует.
     * @param passport паспорт пользователя, которому добавляется счет
     * @param account счет, который добавляется к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по его паспорту.
     * @param passport паспорт пользователя, которого необходимо найти
     * @return возвращает пользователя, если он найден, или null, если не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит счет по паспорту пользователя и реквизитам счета.
     * @param passport паспорт пользователя, которому принадлежит счет
     * @param requisite реквизиты счета, который необходимо найти
     * @return возвращает счет, если он найден, или null, если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }

        }
        return null;
    }

    /**
     * Метод производит перевод денег между двумя счетами.
     * @param sourcePassport паспорт пользователя, который переводит деньги
     * @param sourceRequisite реквизиты счета, с которого производится перевод
     * @param destinationPassport паспорт пользователя, которому переводятся деньги
     * @param destinationRequisite реквизиты счета, на который производится перевод
     * @param amount сумма денег, которая переводится
     * @return возвращает true, если перевод успешен, или false, если не успешен
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport,
            String destinationRequisite, double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает список счетов пользователя.
     * @param user пользователь, счета которого необходимо вернуть
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
