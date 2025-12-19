# 🛠️ Build Configuration & Dependency Resolution DSL

> **A Lightweight, Declarative Build Automation Tool for Java Projects**

DSL (*Domain-Specific Language*) ini dirancang untuk menyederhanakan proses manajemen proyek Java. Tidak perlu lagi pusing dengan perintah `javac` yang panjang, pengaturan *classpath* manual, atau struktur folder yang berantakan. DSL ini menangani semuanya secara otomatis dengan pendekatan **Smart Build Automation**.

---

## ✨ Fitur Unggulan

Sistem ini mengubah cara Anda membangun aplikasi Java dengan fitur-fitur cerdas berikut:

* **🚀 Declarative Syntax:** Tulis konfigurasi build dalam bahasa yang mudah dibaca manusia, bukan skrip shell yang rumit.
* **📦 Automated Dependency Resolution:** Cukup sebutkan library yang dibutuhkan (misal: `com.google.code.gson:gson`), sistem akan mengunduh dan mengaturnya otomatis.
* **🧠 Smart Compile (Auto-Discovery):** Tidak perlu mendaftar file `.java` satu per satu. Sistem melakukan *deep scan* rekursif untuk menemukan semua kode sumber dan library.
* **📂 Smart Organize (Package Mirroring):** Menyalin file sumber ke folder build dengan mempertahankan struktur *package* hirarkis (tidak di-*flatten*), mencegah konflik nama file.
* **🖥️ Cross-Platform Compatibility:** Berjalan mulus di **Windows, Linux, dan macOS**. Sistem otomatis menyesuaikan *path separator* (`/` atau `\`) dan *classpath separator* (`:` atau `;`).
* **⌨️ Interactive CLI Support:** Mendukung aplikasi konsol interaktif (input/output) berkat fitur *I/O Inheritance*.
* **🏗️ Project Scaffolding:** Mendukung pembuatan proyek baru berdasarkan template (*blueprint*).

---

## 📋 Prasyarat

Sebelum menjalankan DSL ini, pastikan sistem Anda memiliki:

* **Java Development Kit (JDK) 8** atau lebih baru.
* Koneksi Internet (untuk mengunduh dependensi pertama kali).

---

## 🚀 Cara Penggunaan

### 1. Struktur Folder
Disarankan menggunakan struktur folder berikut agar build berjalan optimal dan bersih:

```text
root/
├── src/                  # Source code DSL (Engine)
├── template_project/     # (Opsional) Template untuk proyek baru
├── build.dsl             # File konfigurasi DSL Anda
└── out/                  # (Otomatis) Hasil build akan muncul di sini
