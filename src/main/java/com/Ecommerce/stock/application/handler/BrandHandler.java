package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.application.mapper.BrandMapper;
import com.ecommerce.stock.application.mapper.PageMapper;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.api.IBrandIn;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandHandler {

    private final IBrandIn brandIn;
    private final BrandMapper brandMapper;

    public BrandDTO createBrand (BrandDTO brandDTO){
        Brand brand = brandMapper.toEntity(brandDTO);

        Brand newBrand = brandIn.createBrand(brand.getName(), brand.getDescription());
        return brandMapper.toDTO(newBrand);
    }

    public Page<BrandDTO> listBrands(Pageable pageable) {
        //parsear Pageable Spring a PageRequestCustom
        PageRequestCustom pageRequestCustom = new PageRequestCustom(pageable.getPageNumber(),pageable.getPageSize(),pageable.getSort().isSorted());
        //usar la interfaz de dominio
        PageCustom<Brand> pageCustom = brandIn.listBrand(pageRequestCustom);
        //convertir PageCustom a Page de Spring y mapearDTOS
        return PageMapper.toSpringPage(
                new PageCustom<>(
                        pageCustom.getContent().stream().map(brandMapper::toDTO).toList(),
                        pageCustom.getTotalElements(),
                        pageCustom.getTotalPages(),
                        pageCustom.getCurrentPage(),
                        pageCustom.isAscending()
                )
        );
    }
}
