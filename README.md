# spring-security-authn-authz-course
Demo code for pluralsight course: https://app.pluralsight.com/library/courses/spring-security-authentication-authorization-layers-of-defense/exercise-files

Spring Security: Authenticvation/Authorization - Building Effective Layers of Defense

### Module 3
You have to remove the tomcat server in webApplication to simulate the CSRF and Clickjacking attack

### Module 4
Use the following to do the SQL injection: ' union Select 1, username, password, 1,1 from users --

##### Spring Vault
$ vault server -dev
$ export VAULT_ADDR='http://127.0.0.1:8200'
$ export VAULT_TOKEN="s.XmpNPoi9sRhYtdKHaQhkHP6x"
$ vault status

