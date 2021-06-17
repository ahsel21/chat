INSERT INTO public.users (user_id, login, password) VALUES (1, 'q', '$2a$10$TbkFXIx3J0PvbnwuJ8KHBO6yGZV4QzErECvdPbfJUvbX6S/IqwU4u');
INSERT INTO public.rooms (room_id, is_bot, is_deleted, name, public_access, owner_id) VALUES (1, false, false, 'Main', true, 1);
INSERT INTO public.roles (role_id, add_users, ban_users, create_rooms, delete_message, delete_users, name, recive_message, rename_rooms, send_message, set_moderators) VALUES (1, true, true, true, true, true, 'ROLE_ADMIN', true, true, true, true);
INSERT INTO public.role_room_user (role_id, room_id, user_id) VALUES (1, 1, 1);
INSERT INTO public.messages (message_id, created_date_time, text, user_id, room_id) VALUES (1, '2021-05-17 14:02:35.000000', 'wrewrwerwer', 1, 1);
INSERT INTO public.chat_users (user_id, room_id, role_id) VALUES (1, 1, 1);
