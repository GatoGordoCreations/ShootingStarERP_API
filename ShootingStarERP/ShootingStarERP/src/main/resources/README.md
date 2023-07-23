# SSL certificate change instructions
---
- Refresh SSL off of email Link
- Use web broqzer option. Download key, "next steps"
- Follow instructions, use email validation
- Check email for key and link
- Return to website to download cert file.
- Ignore the .pb7 file.  It is just a combination of the other two.
- Run below command in CMD
```
openssl pkcs12 -export -out shootingstarerp.com.pkcs12 -inkey shootingstarerp.com_key.txt -in shootingstarerp.com.crt -certfile shootingstarerp.com.ca-bundle -name ggc
```

- Add Keystore to target folder and update application.properties file as necessary.
- Rebuild project and run CI/CD pipeline