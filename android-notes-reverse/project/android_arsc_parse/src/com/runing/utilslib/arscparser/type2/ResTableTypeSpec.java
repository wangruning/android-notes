package com.runing.utilslib.arscparser.type2;

/*
struct ResTable_typeSpec
{
    struct ResChunk_header header;

    // The type identifier this chunk is holding.  Type IDs start
    // at 1 (corresponding to the value of the type bits in a
    // resource identifier).  0 is invalid.
    uint8_t id;

    // Must be 0.
    uint8_t res0;
    // Must be 0.
    uint16_t res1;

    // Number of uint32_t entry configuration masks that follow.
    uint32_t entryCount;

    enum {
        // Additional flag indicating an entry is public.
        SPEC_PUBLIC = 0x40000000
    };
};
 */

import com.runing.utilslib.arscparser.util.Bytes;
import com.runing.utilslib.arscparser.util.objectio.Struct;

/**
 * 类型规范数据块。
 */
public class ResTableTypeSpec implements Struct {
  private static final int SPEC_PUBLIC = 0x40000000;
  /**
   * {@link ResChunkHeader#type} = {@link ResourceTypes#RES_TABLE_TYPE_SPEC_TYPE}
   * <p>
   * {@link ResChunkHeader#headerSize} = sizeOf(ResTableTypeSpec.class) 表示头部大小。
   * <p>
   * {@link ResChunkHeader#size} = header.headerSize + {@link Integer#BYTES} * {@link #entryCount}
   */
  public ResChunkHeader header;
  /** 资源 Type ID */
  public byte id;
  /** 0，保留 */
  public byte res0;
  /** 0，保留 */
  public short res1;
  /** 本类型的资源项个数，即名称相同的资源项的个数 */
  public int entryCount;

  @Override
  public String toString() {
    return Config.BEAUTIFUL ?
        "{" +
            "header=" + header +
            ", id=" + Bytes.toHex(new byte[]{id}) +
            ", res0=" + res0 +
            ", res1=" + res1 +
            ", entryCount=" + entryCount +
            '}'
        :
        "ResTableTypeSpec{" +
            "header=" + header +
            ", id=" + id +
            ", res0=" + res0 +
            ", res1=" + res1 +
            ", entryCount=" + entryCount +
            '}';
  }
}
