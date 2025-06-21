package za.co.user.Service;

import za.co.user.Domain.User;

import java.util.List;

public interface IUserService extends IService<User, String>{
    List<User> getAll();
}
