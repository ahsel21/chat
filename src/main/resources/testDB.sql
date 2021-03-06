INSERT INTO public.users (user_id, login, password) VALUES (1, 'user1', 'q');
INSERT INTO public.users (user_id, login, password) VALUES (2, 'user2', 'q');
INSERT INTO public.users (user_id, login, password) VALUES (3, 'user3', 'q');
INSERT INTO public.users (user_id, login, password) VALUES (222, 'USER222', '1');

INSERT INTO public.rooms (room_id, name, public_access, owner_id) VALUES (1, 'room1', true, 1);


INSERT INTO public.roles (role_id, add_users, ban_users, create_rooms, delete_message, delete_users, name, recive_message, rename_rooms, send_message, set_moderators) VALUES (2, true, false, true, true, false, 'noadmin', true, true, true, false);
INSERT INTO public.roles (role_id, add_users, ban_users, create_rooms, delete_message, delete_users, name, recive_message, rename_rooms, send_message, set_moderators) VALUES (1, true, true, true, true, true, 'admin', true, true, true, true);

INSERT INTO public.chat_users (room_id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO public.chat_users (room_id, user_id, role_id) VALUES (1, 222, 2);


-- тестовый запросик
SELECT U.login, US.user_id, R.name, U.password, RO.name, RO.public_access, RO.owner_id FROM USERS U JOIN CHAT_USERS US ON U.user_id = US.user_id
                                                                                                    JOIN ROOMS RO ON US.room_id = RO.room_id
                                                                                                    JOIN ROLES R ON US.role_id = R.role_id;
