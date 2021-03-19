# spring-security-authn-authz-course
Demo code for pluralsight course: https://app.pluralsight.com/library/courses/spring-security-authentication-authorization-layers-of-defense/exercise-files

Spring Security: Authenticvation/Authorization - Building Effective Layers of Defense

### Module 3
You have to remove the tomcat server in webApplication to simulate the CSRF and Clickjacking attack

### Module 4
Use the following to do the SQL injection: ' union Select 1, username, password, 1,1 from users --

#### Spring Vault for this module
##### 1. create a vault.conf file
##### 2. $vault server -config vault.conf
##### 3. $export VAULT_ADDR='http://127.0.0.1:8200'
##### 4. $vault operator init
##### 5. $vault status to verify that the vault is sealed
##### 6. $vault operator unseal mWtM+g12vUs164Jz187S3bMz/4sTrSWLe0G2+mgf7p66 // key 1
##### 7. $vault operator unseal V3TyzHG3W1zoe8IML3bMT9eKuu1CtvgY5kXsUC9BUDb3  // key 2
##### 8. $vault operator unseal KOQol2jIRPgxZnboiy0KSpxtdR1OU6oa/EX1jkj+2u9t // key 3
##### 9. $export VAULT_TOKEN="s.qpdbzYSyEDxlo64bR4lIKJvI"
##### 10. $vault secrets enable -path=secret kv
##### 11. $vault write secret/crypt keystore_password=password


#### Some commands
$vault secrets list -detailed // list all of the path where we can store a secret

$value secrets list

#### Spring Vault Starting DEV server
$ vault server -dev

$ export VAULT_ADDR='http://127.0.0.1:8200'

$ export VAULT_TOKEN="s.XmpNPoi9sRhYtdKHaQhkHP6x"

$ vault status


