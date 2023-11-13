INSERT INTO ar_app (id, name, author, app_type, required_runtime_version, status, weight, description, create_by, create_time, update_by, update_time, del_flag, latest_version) VALUES
('test001', 'example', 'dudiao', 'java', '17', NULL, 0, '<p>官方示例项目</p>', '超级管理员', '2023-11-10 15:56:12', NULL, '2023-11-10 15:56:12', 0, NULL);

INSERT INTO ar_app_version (id, version, version_num, status, description, github_download_url, gitee_download_url, create_by, create_time, update_by, update_time, del_flag, app_id) VALUES
('test002', 'v0.0.3', 3, 'release', NULL, NULL, 'https://gitee.com/songyinyin/stm-examples/releases/download/v0.0.3/stm-examples.jar', '超级管理员', '2023-11-10 16:09:20', NULL, '2023-11-10 16:09:20', 0, 'test001'),
('test003', 'v0.0.2', 2, 'release', NULL, 'https://github.com/dudiao/stm-examples/releases/download/v0.0.2/stm-examples.jar', NULL, '超级管理员', '2023-11-10 16:15:40', NULL, '2023-11-10 16:15:40', 0, 'test001');