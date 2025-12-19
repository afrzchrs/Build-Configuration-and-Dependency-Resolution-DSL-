# 🛠️ Build Configuration & Dependency Resolution DSL

> **A Lightweight, Declarative, and Smart Build Automation Tool for Java Projects**

DSL (*Domain-Specific Language*) ini dirancang untuk merevolusi cara Anda membangun aplikasi Java. Tidak perlu lagi pusing dengan perintah `javac` yang panjang, konfigurasi *classpath* manual, atau struktur folder yang berantakan.

Sistem ini menggunakan pendekatan **Smart Build Automation** untuk mendeteksi kode sumber, mengunduh library, dan menjalankan aplikasi secara otomatis, baik untuk proyek yang sudah ada maupun pembuatan proyek baru.

---

## ✨ Fitur Unggulan

* **🚀 Declarative Syntax:** Konfigurasi build menggunakan bahasa yang mudah dibaca manusia.
* **📦 Automated Dependency Resolution:** Otomatis mengunduh library dari Maven Central hanya dengan satu baris kode (misal: `DEPEND "com.google.code.gson:gson"`).
* **🧠 Smart Compile (Auto-Discovery):** Melakukan *Deep Scan* rekursif untuk menemukan semua file `.java` dan library `.jar` tanpa perlu konfigurasi manual.
* **📂 Smart Organize (Package Mirroring):** Menyalin file sumber ke folder build dengan mempertahankan struktur *package* hirarkis (mencegah konflik nama file dan error *package*).
* **🛡️ Recursive Safety:** Dilengkapi filter cerdas untuk mencegah *infinite loop* saat menyalin file template.
* **🖥️ Cross-Platform:** Berjalan mulus di **Windows, Linux, dan macOS** (otomatis menyesuaikan path separator `/` atau `\`).
* **⌨️ Interactive CLI Support:** Mendukung aplikasi konsol interaktif (input/output) melalui mekanisme *I/O Inheritance*.

---

## 📋 Prasyarat

* **Java Development Kit (JDK) 8** atau lebih baru.
* **ANTLR 4.13.2 Runtime** (disertakan dalam proyek ini).
* Koneksi Internet (untuk mengunduh dependensi pertama kali).

---

## 📂 Struktur Folder Proyek

Agar sistem berjalan optimal dan aman dari error rekursif, gunakan struktur berikut:

```text
root/
├── antlr-4.13.2-complete.jar   # Library ANTLR (Wajib)
├── src/                        # Source Code DSL (Engine)
├── java_template/              # (Opsional) Folder Template untuk proyek baru
├── reservasihotel_copy/        # (Opsional) Folder proyek lama yang ingin dirapikan
├── build.dsl                   # File konfigurasi utama
└── out/                        # (Otomatis) Hasil build akan muncul di sini

```

---

## 🚀 Panduan Penggunaan Detail

DSL ini mendukung dua skenario utama:

### Skenario 1: Merapikan & Build Proyek Eksisting (Legacy)

Gunakan ini jika Anda memiliki proyek Java yang berantakan dan ingin merapikannya ke standar struktur (`src`, `bin`, `lib`) serta menjalankannya.

**Konfigurasi `build.dsl`:**

```text
// Arahkan FROM ke folder proyek lama Anda
PROJECT "HotelSystem_Fixed" FROM "./reservasihotel_copy" {

    // (Opsional) Tambahkan library jika proyek lama butuh
    // DEPEND "library:name" VERSION "1.0"

    TASK fix_and_run:
        // 1. Membersihkan 'out', menyalin source, dan menata package
        ECHO ">>> [1] Merapikan File..."
        ORGANIZE

        // 2. Download dependensi (jika ada)
        FIX_DEPENDENCIES

        // 3. Compile otomatis (Deep Scan file .java & .jar)
        ECHO ">>> [2] Mengompilasi..."
        RUN "COMPILE"
        
        // 4. Jalankan Main Class (Input/Output Terminal aktif)
        ECHO ">>> [3] Menjalankan Aplikasi..."
        RUN "START reservasihotel.Main"
    END
}

```

### Skenario 2: Deklarasi Proyek Baru (Templating)

Gunakan ini untuk membuat proyek baru yang bersih (*Scaffolding*) berdasarkan folder template.

**Konfigurasi `build.dsl`:**

```text
// Arahkan FROM ke folder template (blueprint)
PROJECT "AplikasiToko" FROM "./java_template" { 

    // Deklarasikan library yang dibutuhkan proyek baru
    DEPEND "com.google.code.gson:gson" VERSION "2.10.1"
    DEPEND "org.jsoup:jsoup" VERSION "1.15.4"

    TASK init_new_project:
        ECHO ">>> [INIT] Membuat Proyek Baru dari Template..."
        
        // 1. Menyalin template ke 'out/AplikasiToko'
        // Sistem otomatis mengabaikan folder 'out' dan 'src/dsl' agar aman.
        ORGANIZE 

        // 2. Mengunduh library agar siap coding
        FIX_DEPENDENCIES 

        // 3. Test Run (Opsional)
        RUN "COMPILE"
        RUN "START Main"
        
        ECHO ">>> [DONE] Proyek baru siap di folder 'out/AplikasiToko'"
    END
}

```

---

## ⚙️ Cara Menjalankan DSL

Buka terminal/CMD di folder *root* proyek:

**1. Kompilasi Engine DSL (Sekali saja):**

```bash
javac -cp ".;antlr-4.13.2-complete.jar" src/dsl/runner/DSLRunner.java

```

**2. Eksekusi `build.dsl`:**

```bash
java -cp ".;src;antlr-4.13.2-complete.jar" dsl.runner.DSLRunner

```

---

## 📚 Kamus Perintah (Keywords)

| Keyword | Fungsi |
| --- | --- |
| `PROJECT "Name" FROM "Path"` | Inisialisasi nama proyek dan lokasi sumber (Source/Template). |
| `DEPEND "Lib" VERSION "v"` | Menambahkan library dari Maven Central. |
| `TASK name: ... END` | Membuat blok tugas. |
| `DO task_name` | Menjalankan task lain (*Task Chaining*). |
| `ORGANIZE` | Membersihkan output, membuat struktur direktori, dan menyalin source code dengan cerdas (*Smart Recursive Mirroring*). |
| `FIX_DEPENDENCIES` | Mengunduh library dan menyimpannya di folder `lib`. |
| `RUN "COMPILE"` | **Perintah Cerdas:** Otomatis scan file `.java`, set classpath, dan compile ke `bin`. |
| `RUN "START MainClass"` | **Perintah Cerdas:** Menjalankan aplikasi dengan classpath otomatis dan dukungan interaktif. |
| `MKDIR`, `COPY`, `DELETE` | Utilitas file dasar. |
| `ECHO "Pesan"` | Menampilkan pesan ke konsol. |

---

## 👥 Tim Pengembang

Proyek ini dikembangkan untuk Tugas Besar mata kuliah **Programming Language Pragmatic**.

| NIM | Nama | Peran & Kontribusi |
| --- | --- | --- |
| **241524002** | **Afriza Choirie Saputra** | Perancangan Grammar, Konsep DSL, Dokumentasi, & Mekanisme JAR Packaging. |
| **241524015** | **Muhamad Dino Dermawan** | Implementasi Visitor Dasar, Logika Eksekusi Task, & Modul Dependency Downloader. |
| **241524027** | **Rizki Nurmahmudi** | Implementasi **Smart Build Features** (Recursive Scanning, Auto-Discovery), Validasi End-to-End, & Interactivity Support. |

---

## 📜 Lisensi

Didistribusikan di bawah lisensi MIT. Bebas digunakan untuk keperluan pendidikan.

---

*Developed with ❤️ using Java & ANTLR4*

```

```
