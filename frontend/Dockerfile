# --- Étape 1 : Build Node.js ---
FROM node:22-alpine AS builder
WORKDIR /app

COPY package*.json ./
RUN npm install --legacy-peer-deps

COPY . .
RUN npm run build

# --- Étape 2 : Serveur Nginx ---
FROM nginx:alpine
WORKDIR /usr/share/nginx/html

# Nettoyage du dossier par défaut de Nginx
RUN rm -rf ./*

# Copie des fichiers compilés (dist) depuis la phase de build
COPY --from=builder /app/dist .

# ✅ Copie de la configuration Nginx personnalisée pour gérer Vue Router
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]