package com.mikko.mmback.dtos;

public record SignUpDto (String firstName, String lastName, String login, char[] password, String phone, String email) {
}
