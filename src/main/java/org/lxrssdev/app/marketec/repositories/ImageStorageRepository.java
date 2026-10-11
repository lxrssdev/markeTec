package org.lxrssdev.app.marketec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService extends JpaRepository<Long, MultipartFile> {
}
