INSERT INTO instructor (name)
VALUES
  ('현우진'),
  ('최선묵'),
  ('현우진');

INSERT INTO student (email, nickname)
VALUES
  ('test1@example.com', '철수'),
  ('test2@example.com', '영희'),
  ('test3@example.com', '민수');

INSERT INTO course (instructor_id, price, created_at, modified_at, description, title, category)
VALUES
  (1, 10000, '2024-07-08 09:31:00', '2024-07-08 09:31:00', '수능 기출', '수분감 수학1', '수학'),
  (2, 20000, '2024-07-08 09:31:00', '2024-07-08 09:31:00', '수능 개념', '지구과학1 개념완성', '과학'),
  (3, 15000, '2024-07-08 09:31:00', '2024-07-08 09:31:00', '고난이도 문제', '두릴 기하와벡터', '수학');