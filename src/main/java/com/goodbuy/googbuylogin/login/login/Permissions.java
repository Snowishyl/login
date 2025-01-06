package com.goodbuy.googbuylogin.login.login;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/11
 * @Email: 2825097536@qq.com
 * @description: 权限枚举, 数字大小默认拥有小于该数字的所有权限
 * @see LoginIdentify
 */
@Getter
@Slf4j
public class Permissions {
    private static volatile Set<Permissions> permissions;
    private static final Object LOCK = new Object();

    public static final Permissions DEFAULT_PERMISSION =new Permissions(0,"default");

    public static Set<Permissions> getPermissions() {
        if (permissions == null) {
            synchronized (LOCK) {
                if (permissions == null) {
                    permissions = new TreeSet<>(Comparator.comparingInt(Permissions::getPermission));
                }
            }
        }
        return permissions;
    }

    private final Integer permission;
    @Setter
    private String description;

    private Permissions(Integer permission, String description) {
        this.permission = permission;
        this.description = description;
    }

    public static void modifyDescription(Integer role, String description) {
        permissions.stream().filter(permission -> permission.permission.equals(role))
                .findFirst().ifPresent(permission -> {
                    permission.setDescription(description);
                });
    }

    public static void addPermission(Permissions permission, String description) throws IllegalAccessException {
        boolean add = permissions.add(permission);
        if (!add) {
            log.error("Permission already exists");
            throw new IllegalAccessException("Permission already exists");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Permissions that)) {
            return false;
        }
        if (that.getPermission().equals(this.getPermission())) {
            return true;
        }
        return Objects.equals(permission, that.permission) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permission, description);
    }
}
