INSERT INTO public.person (id, username, password, email) VALUES (1, 'admin', '$2a$10$aXpu1lorpayTSJeOYCxQcOWyoGBr6dEEj475OfuXPojnbAKFsEWFi', 'admin@email.com');
INSERT INTO public.person (id, username, password, email) VALUES (2, 'moder', '$2a$10$aXpu1lorpayTSJeOYCxQcOWyoGBr6dEEj475OfuXPojnbAKFsEWFi', 'moder@email.com');
INSERT INTO public.person (id, username, password, email) VALUES (3, 'user', '$2a$10$aXpu1lorpayTSJeOYCxQcOWyoGBr6dEEj475OfuXPojnbAKFsEWFi', 'user@email.com');

INSERT INTO public.room (id, name, is_private, is_bot, is_deleted) VALUES (1, 'Public', false, false, false);

INSERT INTO public.message (id, user_id, message_text, created_date_time, room_id) VALUES (1, 1, 'HELLO', '2021-06-26 16:55:24.946485', 1);

INSERT INTO public.room_role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO public.room_role (id, name) VALUES (2, 'ROLE_MODERATOR');
INSERT INTO public.room_role (id, name) VALUES (3, 'ROLE_ADMIN');

INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (1, 1, 1, 1);
INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (2, 2, 1, 1);
INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (3, 3, 1, 1);
INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (4, 2, 1, 2);
INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (5, 3, 1, 2);
INSERT INTO public.role_room_user (id, role_id, room_id, user_id) VALUES (6, 3, 1, 3);





