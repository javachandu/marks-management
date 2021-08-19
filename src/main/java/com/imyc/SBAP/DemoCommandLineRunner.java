package com.imyc.SBAP;

import java.util.*;

import com.imyc.SBAP.Http.privilege.dao.Privilege;
import com.imyc.SBAP.Http.privilege.dao.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.imyc.SBAP.Http.role.dao.Role;
import com.imyc.SBAP.Http.role.dao.repository.RoleRepository;
import com.imyc.SBAP.Http.user.dao.User;
import com.imyc.SBAP.Http.user.dao.repository.UserRepository;

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private RoleRepository rolesRepository;

	@Autowired
	private UserRepository usersRepository;

	@Autowired
    private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
        Optional<User> existingUser = usersRepository.findByUsername("santhosh@admin");
        if (!existingUser.isPresent()) {
            Date date = new Date();

            User user = new User();
            user.setUsername("santhosh");
            user.setPassword(passwordEncoder.encode("santhosh@123"));
            user.setName("Admin");
            user.setEmail("santhosh@admin.com");
            user.setDisabled(false);
            user.setAccountExpired(false);
            user.setAccountLocked(false);
            user.setCredentialsExpired(false);
            user.setCreatedAt(date);
            user.setUpdatedAt(date);
            usersRepository.save(user);


            //user role
            User studentUser = new User();
            studentUser.setUsername("student");
            studentUser.setPassword(passwordEncoder.encode("student"));
            studentUser.setName("Student");
            studentUser.setEmail("student@test.com");
            studentUser.setDisabled(false);
            studentUser.setAccountExpired(false);
            studentUser.setAccountLocked(false);
            studentUser.setCredentialsExpired(false);
            studentUser.setCreatedAt(date);
            studentUser.setUpdatedAt(date);
            usersRepository.save(studentUser);

            Role role = new Role();
            role.setAdmin(true);
            role.setName("ADMIN");
            role.setCreatedAt(date);
            role.setUpdatedAt(date);
            rolesRepository.save(role);

            Role role2 = new Role();
            role2.setAdmin(false);
            role2.setName("USER");
            role2.setCreatedAt(date);
            role2.setUpdatedAt(date);
            rolesRepository.save(role2);
            Set<Role> hSet = new HashSet<>();
            for (Role x : Arrays.asList(role))
                hSet.add(x);
            user.setRoles(hSet);
            usersRepository.save(user);
            Set<Role> userRole = new HashSet<>();
            userRole.add(role2);
            studentUser.setRoles(userRole);

            String[] priilegeNameList = {"Dashboard_INDEX", "Role_INDEX", "Role_CREATE",
                    "Role_UPDATE", "Role_DELETE", "User_INDEX", "User_READ", "User_CREATE",
                    "User_UPDATE", "User_DELETE"};
            List<Privilege> priilegeList = new ArrayList<>();
            for (String name : priilegeNameList) {
                Privilege privilege = new Privilege();
                privilege.setName(name);
                privilegeRepository.save(privilege);
                priilegeList.add(privilege);
            }
            Set<Privilege> priset = new HashSet<>();
            for (Privilege x : priilegeList)
                priset.add(x);

            role.setPrivileges(priset);
            rolesRepository.save(role);

            role2.setPrivileges(priset);
            rolesRepository.save(role2);
        }
    }
}