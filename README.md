# 📱 CRUD Mobile App

A complete mobile CRUD (Create, Read, Update, Delete) application built with Java for Android.

## 📋 Description

Full-featured mobile application demonstrating CRUD operations for managing data on Android devices. Perfect for learning mobile development with Java.

## ✨ Features

- ✅ Create new records
- ✅ Read/View records
- ✅ Update existing data
- ✅ Delete records
- ✅ Local database storage
- ✅ User-friendly interface
- ✅ Input validation

## 🛠️ Technologies

- **Java**: Core language
- **Android SDK**: Mobile framework
- **SQLite**: Local database
- **XML**: UI layouts

## 📋 Requirements

- Android API 21+
- Android Studio
- JDK 8+

## 🚀 Installation

```bash
# Clone the repository
git clone https://github.com/ayman-06-stack/crud_app_mobile.git

# Open in Android Studio
# Build and run on emulator or device
```

## 📊 Database Schema

```sql
CREATE TABLE items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);
```

## 📸 Screenshots

- List View: Display all items
- Detail View: View item details
- Add/Edit Form: Create or modify items
- Delete: Remove items

## 🤝 Contributing

Contributions are welcome! Please feel free to submit pull requests.

## 📝 License

MIT License

## 👤 Author

**Ayman Guendouz**
- GitHub: [@ayman-06-stack](https://github.com/ayman-06-stack)
- Email: aymanguendouz07@gmail.com
- LinkedIn: [Ayman Guendouz](https://www.linkedin.com/in/ayman-guendouz)
