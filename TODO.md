# Change Hostname

### Keycloak

Client ID: vote-app
Redirect URIs: http://localhost:4200/\* & http://localhost:8080/\*

### Angular

app.module.ts

```typescript
export const authConfig: AuthConfig = {
  issuer: 'http://desktop-8umomf4:8080/realms/ILV', ....
```

src/environments/environment.ts

```typescript
backendBaseUrl: 'http://desktop-8umomf4:9090/api/v1/',
frontendBaseUrl: 'http://desktop-8umomf4:4200'
```
