import { FileHandle } from "./file-handle.model";

export class Listing {
    id !: number;
    name !: string;
    description !: string;
    price !: number;
    city !: string;
    beds !: number;
    baths !: number;
    m2 !: number;
    sellOrRent !: Boolean;
    categorieId !:number;
    dateCreated !: Date;
    // ListingImages !: FileHandle[]
}
// dateCreated !: Date;