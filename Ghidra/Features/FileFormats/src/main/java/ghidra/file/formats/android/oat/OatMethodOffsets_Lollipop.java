/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.file.formats.android.oat;

import java.io.IOException;

import ghidra.app.util.bin.BinaryReader;
import ghidra.program.model.data.*;
import ghidra.util.exception.DuplicateNameException;

/**
 * 
 * https://android.googlesource.com/platform/art/+/lollipop-release/runtime/oat.h#161
 *
 */
public class OatMethodOffsets_Lollipop extends OatMethodOffsets {

	private int gc_map_offset_;

	public OatMethodOffsets_Lollipop(BinaryReader reader) throws IOException {
		super(reader);
		gc_map_offset_ = reader.readNextInt();
	}

	public int getGcMapOffset() {
		return gc_map_offset_;
	}

	@Override
	public DataType toDataType() throws DuplicateNameException, IOException {
		Structure structure = (Structure) super.toDataType();
		structure.add(DWORD, "gc_map_offset_", null);
		structure.setCategoryPath(new CategoryPath("/oat"));
		return structure;
	}
}
