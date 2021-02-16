
CREATE TABLE users (
  username text primary key,
  password text NOT NULL,
  enabled boolean DEFAULT TRUE
);

CREATE TABLE authorities (
  username text primary key references users(username),
  authority text DEFAULT 'ROLE_USER'
);

CREATE TABLE user_info (
    username text primary key references users(username),
    full_name text,
    age text not null,
    height text,
    gender text not null,
    education text,
    profession text,
    organization text,
    about_you text,
    qualities_looking_for text,
    country text not null,
    state text not null,
    city text not null,
    pincode text not null,
    mobile text not null,
    profile_image bytea
);